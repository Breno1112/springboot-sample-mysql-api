CREATE USER IF NOT EXISTS 'userapi'@'%' IDENTIFIED BY 'userapipassword';
GO
GRANT ALL ON `project`.* TO 'userapi';