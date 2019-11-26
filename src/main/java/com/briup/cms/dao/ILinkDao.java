package com.briup.cms.dao;

import com.briup.cms.bean.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface ILinkDao extends JpaRepository<Link , Integer> {

    Link queryById(int id);

}
