package com.entity.model;

import com.entity.XianchangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 现场勘查
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XianchangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 现场勘查名称
     */
    private String xianchangName;


    /**
     * 现场勘查编号
     */
    private String xianchangUuidNumber;


    /**
     * 现场勘查照片
     */
    private String xianchangPhoto;


    /**
     * 现场勘查类型
     */
    private Integer xianchangTypes;


    /**
     * 文件
     */
    private String xianchangFile;


    /**
     * 现场勘查备注
     */
    private String xianchangContent;


    /**
     * 逻辑删除
     */
    private Integer xianchangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：现场勘查名称
	 */
    public String getXianchangName() {
        return xianchangName;
    }


    /**
	 * 设置：现场勘查名称
	 */
    public void setXianchangName(String xianchangName) {
        this.xianchangName = xianchangName;
    }
    /**
	 * 获取：现场勘查编号
	 */
    public String getXianchangUuidNumber() {
        return xianchangUuidNumber;
    }


    /**
	 * 设置：现场勘查编号
	 */
    public void setXianchangUuidNumber(String xianchangUuidNumber) {
        this.xianchangUuidNumber = xianchangUuidNumber;
    }
    /**
	 * 获取：现场勘查照片
	 */
    public String getXianchangPhoto() {
        return xianchangPhoto;
    }


    /**
	 * 设置：现场勘查照片
	 */
    public void setXianchangPhoto(String xianchangPhoto) {
        this.xianchangPhoto = xianchangPhoto;
    }
    /**
	 * 获取：现场勘查类型
	 */
    public Integer getXianchangTypes() {
        return xianchangTypes;
    }


    /**
	 * 设置：现场勘查类型
	 */
    public void setXianchangTypes(Integer xianchangTypes) {
        this.xianchangTypes = xianchangTypes;
    }
    /**
	 * 获取：文件
	 */
    public String getXianchangFile() {
        return xianchangFile;
    }


    /**
	 * 设置：文件
	 */
    public void setXianchangFile(String xianchangFile) {
        this.xianchangFile = xianchangFile;
    }
    /**
	 * 获取：现场勘查备注
	 */
    public String getXianchangContent() {
        return xianchangContent;
    }


    /**
	 * 设置：现场勘查备注
	 */
    public void setXianchangContent(String xianchangContent) {
        this.xianchangContent = xianchangContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXianchangDelete() {
        return xianchangDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setXianchangDelete(Integer xianchangDelete) {
        this.xianchangDelete = xianchangDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
