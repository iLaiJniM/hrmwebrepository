package com.lijiamin.dao;

import com.lijiamin.model.Resume;

import java.util.List;

/**
 * Created by 31543 on 2018/10/20.
 */
public interface ResumeDao {
    Integer insertResume(Resume Resume);    //�����
    Integer deleteResume(Resume Resume);    //ɾ����
    Integer updateResume(Resume Resume);    //�ļ���
    Resume queryResumeByResume_id(Integer resume_id);   //�ݼ���id�����
    List<Resume> queryResumeByResume_user_id(Integer resume_user_id);   //���û�id���������
}
