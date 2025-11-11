package com.smartattendance.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    private JdbcTemplate jdbc;

    // Raw JDBC (via JdbcTemplate) report to satisfy JDBC requirement
    public List<Map<String,Object>> attendanceSummary() {
        String sql = "SELECT s.name, s.roll_no, COUNT(a.attendance_id) AS total, " +
                     "SUM(CASE WHEN a.status='Present' THEN 1 ELSE 0 END) AS presents " +
                     "FROM student s LEFT JOIN attendance a ON s.student_id=a.student_id " +
                     "GROUP BY s.student_id";
        return jdbc.queryForList(sql);
    }
}
