package net.ww.web.italker.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by HP on 2017/10/27.
 * 用户关系的model,用于用户直接进行好友关系的实现
 */
@Entity
@Table(name = "TB_USER_FOLLOW")
public class UserFollow {


    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;

    //定义一个发起人，你关注某人，这里就是你
    //多对1，你可以关注很多人，你的每一次关注都是一条记录
    //你可以创建多个关注的信息，所以是多对1
    //option 不可选  必须储存，一条关注记录里面一定要有一个”你“
    @ManyToOne(optional = false)
    //定义关联表中字段originId，对应的是user.id
    //定义的是数据库中的存储字段
    @JoinColumn(name = "originId" )
    private User origin;


    //把这个列提取到我们的model中，不允许为null，不允许更新和插入
    @Column(nullable = false,updatable = false,insertable = false)
    private String originId;

    //定义关注的目标，你关注的人
    //也是多对1，你看也别多个人关注，每次关注都是一条记录
    //所以就是多个Userfollow 多以一个User的情况
    @ManyToOne(optional=false)
    //定义关联表中字段targetId，对应的是user.id
    //定义的是数据库中的存储字段
    @JoinColumn(name = "targetId" )
    private User  target;

    //把这个列提取到我们的model中，不允许为null，不允许更新和插入
    @Column(nullable = false,updatable = false,insertable = false)
    private String targetId;

    //别名，也就是target的备注名
    @Column
    private String alias;

    // 定义为创建时间戳，在创建时就已经写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    // 定义为更新时间戳，在创建时就已经写入
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();

}
