package com.example.jobjet.repository;

import com.example.jobjet.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    // JpaRepository đã cung cấp sẵn các phương thức CRUD cơ bản
    // như findAll(), findById(), save(), deleteById(),...
    // Chúng ta không cần viết thêm gì ở đây cho các yêu cầu cơ bản.
}