package com.lijiamin.service.serviceImpl;

import com.lijiamin.dao.ResumeDao;
import com.lijiamin.model.Resume;
import com.lijiamin.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 31543 on 2018/10/20.
 */
@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeDao resumeDao;

    public Boolean insertResume(Resume resume) {
        if(null != resume){
            Integer i = resumeDao.insertResume(resume);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public Boolean deleteResume(Resume resume) {
        if(null != resume){
            Integer i = resumeDao.deleteResume(resume);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public Boolean updateResume(Resume resume) {
        if(null != resume){
            Integer i = resumeDao.updateResume(resume);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public Resume queryResumeByResume_id(Integer resume_id) {
        if(null != resume_id && resume_id > 0){
            return resumeDao.queryResumeByResume_id(resume_id);
        }
        return null;
    }

    public List<Resume> queryResumeByResume_user_id(Integer resume_user_id) {
        if(null != resume_user_id && resume_user_id > 0){
            List<Resume> resumeList = resumeDao.queryResumeByResume_user_id(resume_user_id);
            if(null != resumeList && resumeList.size() >= 0){
                return resumeList;
            }
        }
        return null;
    }
}
