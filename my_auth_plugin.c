/* Copyright (C) 2018 Werner */

#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <mysql/plugin_auth.h>
#include <mysql/auth_dialog_client.h>

static int school_number_auth(MYSQL_PLUGIN_VIO *vio, MYSQL_SERVER_AUTH_INFO *info)
{
    /* 该函数是实际上进行认证的地方，
           认证通过返回CR_OK，
           认证失败返回CR_ERROR; */
    int pkt_len;
    unsigned char *pkt;

    if (vio->write_packet(vio, (const unsigned char *)ORDINARY_QUESTION "Please enter your name: ", 26))
        return CR_ERROR;

    if ((pkt_len = vio->read_packet(vio, &pkt)) < 0)
        return CR_ERROR;

    if (strcmp((const char *)pkt, info->user_name))
        return CR_ERROR;

    if (vio->write_packet(vio, (const unsigned char *)LAST_QUESTION "Please enter your school number: ", 35))
        return CR_ERROR;

    if ((pkt_len = vio->read_packet(vio, &pkt)) < 0)
        return CR_ERROR;

    if (strcmp((const char *)pkt, info->auth_string))
        return CR_ERROR;

    return CR_OK;
}

static struct st_mysql_auth my_auth_plugin = {
    MYSQL_AUTHENTICATION_INTERFACE_VERSION, // 插件的接口版本号
    "dialog",                               // 客户端侧处理函数，我们直接使用了“dialog”，也可以自定义
    school_number_auth};                    // 服务器侧处理函数

mysql_declare_plugin(dialog){
    MYSQL_AUTHENTICATION_PLUGIN,    // 插件类型
    &my_auth_plugin,                // 插件结构体指针
    "school_number",                // 插件名
    "Werner",                       // 作者
    "A simple MariaDB auth plugin", // 描述
    PLUGIN_LICENSE_GPL,             // 许可证书
    NULL,
    NULL,
    0x0100,
    NULL,
    NULL,
    NULL,
    0,
} mysql_declare_plugin_end;