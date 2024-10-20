package com.entity.vo;

import com.entity.XianchangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 现场勘查
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xianchang")
public class XianchangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 现场勘查名称
     */

    @TableField(value = "xianchang_name")
    private String xianchangName;


    /**
     * 现场勘查编号
     */

    @TableField(value = "xianchang_uuid_number")
    private String xianchangUuidNumber;


    /**
     * 现场勘查照片
     */

    @TableField(value = "xianchang_photo")
    private String xianchangPhoto;


    /**
     * 现场勘查类型
     */

    @TableField(value = "xianchang_types")
    private Integer xianchangTypes;


    /**
     * 文件
     */

    @TableField(value = "xianchang_file")
    private String xianchangFile;


    /**
     * 现场勘查备注
     */

    @TableField(value = "xianchang_content")
    private String xianchangContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "xianchang_delete")
    private Integer xianchangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：现场勘查名称
	 */
    public String getXianchangName() {
        return xianchangName;
    }


    /**
	 * 获取：现场勘查名称
	 */

    public void setXianchangName(String xianchangName) {
        this.xianchangName = xianchangName;
    }
    /**
	 * 设置：现场勘查编号
	 */
    public String getXianchangUuidNumber() {
        return xianchangUuidNumber;
    }


    /**
	 * 获取：现场勘查编号
	 */

    public void setXianchangUuidNumber(String xianchangUuidNumber) {
        this.xianchangUuidNumber = xianchangUuidNumber;
    }
    /**
	 * 设置：现场勘查照片
	 */
    public String getXianchangPhoto() {
        return xianchangPhoto;
    }


    /**
	 * 获取：现场勘查照片
	 */

    public void setXianchangPhoto(String xianchangPhoto) {
        this.xianchangPhoto = xianchangPhoto;
    }
    /**
	 * 设置：现场勘查类型
	 */
    public Integer getXianchangTypes() {
        return xianchangTypes;
    }


    /**
	 * 获取：现场勘查类型
	 */

    public void setXianchangTypes(Integer xianchangTypes) {
        this.xianchangTypes = xianchangTypes;
    }
    /**
	 * 设置：文件
	 */
    public String getXianchangFile() {
        return xianchangFile;
    }


    /**
	 * 获取：文件
	 */

    public void setXianchangFile(String xianchangFile) {
        this.xianchangFile = xianchangFile;
    }
    /**
	 * 设置：现场勘查备注
	 */
    public String getXianchangContent() {
        return xianchangContent;
    }


    /**
	 * 获取：现场勘查备注
	 */

    public void setXianchangContent(String xianchangContent) {
        this.xianchangContent = xianchangContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXianchangDelete() {
        return xianchangDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setXianchangDelete(Integer xianchangDelete) {
        this.xianchangDelete = xianchangDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
