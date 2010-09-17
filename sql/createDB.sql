create database callcenter;

create user callcenter@localhost identified by 'callcenter';

grant all on callcenter.* to callcenter;

