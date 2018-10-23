package com.lijiamin.service;

import com.lijiamin.model.Resume;

import java.util.List;

/**
 * Created by 31543 on 2018/10/20.
 */
public interface ResumeService {
    Boolean insertResume(Resume resume);    //�����
    Boolean deleteResume(Resume resume);    //ɾ����
    Boolean updateResume(Resume resume);    //�ļ���
    Resume queryResumeByResume_id(Integer resume_id);   //�ݼ���id�����
    List<Resume> queryResumeByResume_user_id(Integer resume_user_id);   //���û�id���������
}
