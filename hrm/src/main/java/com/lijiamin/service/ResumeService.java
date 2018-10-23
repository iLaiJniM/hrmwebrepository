package com.lijiamin.service;

import com.lijiamin.model.Resume;

import java.util.List;

/**
 * Created by 31543 on 2018/10/20.
 */
public interface ResumeService {
    Boolean insertResume(Resume resume);    //添简历
    Boolean deleteResume(Resume resume);    //删简历
    Boolean updateResume(Resume resume);    //改简历
    Resume queryResumeByResume_id(Integer resume_id);   //据简历id查简历
    List<Resume> queryResumeByResume_user_id(Integer resume_user_id);   //据用户id查简历集合
}
