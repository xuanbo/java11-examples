/**
 * 用户服务模块
 *
 * @since 1.0
 */
open module user.service {
    requires user.api;

    requires java.sql;

    requires jdk.unsupported;

    requires spring.core;
    requires spring.beans;
    requires spring.context;
    requires spring.web;
    requires spring.boot;
    requires spring.boot.autoconfigure;

    exports tk.fishfish.java11examples;
    exports tk.fishfish.java11examples.service.impl;
    exports tk.fishfish.java11examples.controller;
}