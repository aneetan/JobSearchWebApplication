package com.example.jobportal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Transactional
@Setter
public class JobDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;
    private String title;
    private String location;
    private String empType;

    @Lob
    @Column(length = 100)
    private String jobDescription;

    @Lob
    @Column(length = 1000)
    private String qualification;

    @Lob
    @Column(length = 100)
    private String skills;
    private String salary;

    @Lob
    @Column(length = 1000)
    private String responsibilities;
    private LocalDate deadline;

    private String jobStatus;

    @ManyToOne
    @JoinColumn(name="companyId")
    private Company company;

    @ManyToOne
    @JoinColumn(name="docId")
    private CompanyDocs companyDocs;

    @OneToMany(mappedBy = "jobDetails", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Applicant> applicantList = new ArrayList<>();

    @ManyToMany(mappedBy = "jobDetails", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<userDocs>  userDocs;

    public JobDetails(){

    }

    public JobDetails(String title, String location, String empType, String jobDescription, String qualification, String skills, String salary, String responsibilities, LocalDate deadline) {
        this.title = title;
        this.location = location;
        this.empType = empType;
        this.jobDescription = jobDescription;
        this.qualification = qualification;
        this.skills = skills;
        this.salary = salary;
        this.responsibilities = responsibilities;
        this.deadline = deadline;
    }
}
