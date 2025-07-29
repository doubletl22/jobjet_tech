package com.example.jobjet.controller;

import com.example.jobjet.model.Job;
import com.example.jobjet.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    /**
     * API để lấy danh sách tất cả công việc.
     * GET /api/jobs
     */
    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    /**
     * API để tạo một công việc mới.
     * POST /api/jobs
     */
    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        // Có thể thêm logic để đặt giá trị mặc định trước khi lưu
        if (job.getStatus() == null || job.getStatus().isEmpty()) {
            job.setStatus("Chờ duyệt");
        }
        job.setPostedDate(LocalDateTime.now());

        Job savedJob = jobRepository.save(job);
        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }

    /**
     * API để lấy thông tin chi tiết của một công việc theo ID.
     * GET /api/jobs/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Optional<Job> jobData = jobRepository.findById(id);

        if (jobData.isPresent()) {
            return new ResponseEntity<>(jobData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}