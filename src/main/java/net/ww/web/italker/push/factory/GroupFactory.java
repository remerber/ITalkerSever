package net.ww.web.italker.push.factory;

import net.ww.web.italker.push.bean.db.Group;
import net.ww.web.italker.push.bean.db.GroupMember;
import net.ww.web.italker.push.bean.db.User;

import java.util.Set;

/**
 * Created by HP on 2017/12/6.
 * 群消息处理类
 */
public class GroupFactory {
    public static Group findById(String groupId) {
        // TODO 查询一个群
        return null;
    }

    public static Group findById(User user, String groupId) {
        // TODO 查询一个群, 同时该User必须为群的成员，否则返回null
        return null;
    }

    public static Set<GroupMember> getMembers(Group group) {
        // TODO 查询一个群的成员
        return null;
    }
}