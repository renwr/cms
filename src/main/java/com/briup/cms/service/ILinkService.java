package com.briup.cms.service;

import com.briup.cms.bean.Link;
import com.briup.cms.exception.CustomerException;

import java.util.List;

public interface ILinkService {

    void saveOrUpdateLink(Link link) throws CustomerException;

    void deleteLinkById(int id) throws CustomerException;

    Link queryLinkById(int id) throws CustomerException;

    List<Link> findLink() throws CustomerException;
}
