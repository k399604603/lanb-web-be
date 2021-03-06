package com.colodoo.framework.manager.config.service;

import com.colodoo.framework.base.abs.BaseService;
import com.colodoo.framework.exception.DAOException;
import com.colodoo.framework.utils.Contants;
import com.colodoo.framework.manager.config.model.Config;
import com.colodoo.framework.easyui.Page;
import com.colodoo.framework.manager.config.model.ConfigExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author colodoo
* @date 2018-8-30 11:25:25
* @description 
*/
@Service
@Slf4j
public class ConfigService extends BaseService<Config> {

    /**
    * 新增数据
    *
    * @param model
    * @return
    */
    public int saveConfig(Config model) {
        int ret = Contants.CODE_FAILED;
        model.setConfigId(uuid());
        // model.setCreateDate(new Date());
        // model.setLastDate(new Date());
        try {
            ret = this.insert(model);
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return ret;
    }

    /**
    * 删除数据
    *
    * @param model
    * @return
    */
    public int deleteConfig(Config model) {
        int ret = Contants.CODE_FAILED;
        try {
            ret = this.delete(model.getConfigId());
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return ret;
    }

    /**
    * 更新数据
    *
    * @param model
    * @return
    */
    public int updateConfig(Config model) {
        int ret = Contants.CODE_FAILED;
        try {
            ret = this.update(model);
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return ret;
    }

    /**
    * 根据id查找单条数据
    *
    * @param model
    * @return
    */
    public Config queryById(Config model) {
        Config config = null;
        try {
            config = this.get(model.getConfigId());
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return config;
    }

    /**
    * 查找列表
    *
    * @return
    */
    public List<Config> query() {
        List<Config> list = null;
        ConfigExample example = new ConfigExample();
        try {
            list = this.find(example);
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return list;
    }

    /**
    * 查找分页列表
    *
    * @param page
    * @return
    */
    public PageInfo query(Page page) {
        PageInfo pageInfo;
        List<Config> list = null;
        PageHelper.startPage(page.getPage(), page.getRows());
        try {
            list = this.find();
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
