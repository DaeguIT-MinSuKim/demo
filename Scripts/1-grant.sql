create database if not exists demo;

-- 계정 추가
drop user if exists 'user_demo'@'localhost';

grant all privileges 
   on demo.* 
   to 'user_demo'@'localhost' identified by 'rootroot';
   
