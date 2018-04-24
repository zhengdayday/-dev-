package com.lunwen.wangjie.dao;

import com.lunwen.wangjie.model.HomeWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created with IDEA
 * author: wangjie
 */
public interface HomeWorkDao extends JpaRepository<HomeWork, Long> {

    /**
     * 根据工号 获取所有作业
     * @param tno 工号
     * @return list work
     */
    List<HomeWork> findAllByTno(String tno);

    /**
     * 工号 作业名 获取作业
     * @param tno 工号
     * @param workName 作业名
     * @return work
     */
    HomeWork findHomeWorkByTnoAndWorkName(String tno, String workName);

    /**
     * 查找作业
     * @param wno 作业号
     * @return work
     */
    HomeWork findHomeWorkByWno(Long wno);

    /**
     * 查找作业
     * @param lno 课程号
     * @return list work
     */
    List<HomeWork> findAllByLno(Long lno);
}