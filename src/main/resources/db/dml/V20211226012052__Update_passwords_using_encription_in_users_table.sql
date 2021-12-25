UPDATE users
SET password = '{bcrypt}$2y$10$Aiz/UDxmLNJBVnA.8YRf.uQud0/HcsYi6RGg/1etNz.FR0A0HCax2'
WHERE username = 'alex';

UPDATE users
SET password = '{bcrypt}$2y$10$MbROnXk9.5Q./Af9LbgCGexIG2pXx3roeeG8HeQ6rIIT6XpVuHnr2'
WHERE username = 'tom';

UPDATE users
SET password = '{bcrypt}$2y$10$gAMCImEQomHfzopv1pEE3.A2VkeUvstGFMdbIcQ4kuCbGGDWmg4FW'
WHERE username = 'admin';

