CREATE DATABASE IF NOT EXISTS attendance_db;
USE attendance_db;

CREATE TABLE IF NOT EXISTS admin (
  admin_id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL
);
CREATE TABLE IF NOT EXISTS student (
  student_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  roll_no VARCHAR(50),
  course VARCHAR(50),
  semester VARCHAR(20)
);
CREATE TABLE IF NOT EXISTS subject (
  subject_id INT AUTO_INCREMENT PRIMARY KEY,
  subject_name VARCHAR(100),
  semester VARCHAR(20)
);
CREATE TABLE IF NOT EXISTS attendance (
  attendance_id INT AUTO_INCREMENT PRIMARY KEY,
  student_id INT,
  subject_id INT,
  date DATE,
  status VARCHAR(10),
  FOREIGN KEY (student_id) REFERENCES student(student_id),
  FOREIGN KEY (subject_id) REFERENCES subject(subject_id)
);

INSERT INTO admin(username,password) VALUES ('aman_admin','Aman@123');
