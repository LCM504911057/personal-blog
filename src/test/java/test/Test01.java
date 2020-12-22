package test;

import com.personal.blog.App;
import com.personal.blog.dao.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;


//@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class Test01 {

    @Autowired
    UserMapper userMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    ColumnistMapper columnistMapper;

    @Autowired
    BlogMapper blogMapper;

    @Test
    public void t1() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "root");
//        User user = userMapper.findUserByCondition(map);
//        System.out.println(user);
        System.out.println(userMapper);
        System.out.println(userMapper.findUserAll());


    }

    @Test
    public void t2() {
//        tagMapper.findTagAll();

//        Tag tag = new Tag();
//        tag.setId(1);
//        tag.setBlogCount(2);
//        tag.setCreateTime(new Date());
//        tag.setName("spring");

//        tagMapper.insertTag(tag);

//        System.out.println(tagMapper.findTagAll());
//
//        tagMapper.updateTag(tag);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "spring");
        System.out.println(tagMapper.findTagByCondition(map));
    }

    @Test
    public void t3() {
        System.out.println(commentMapper.findCommentAll());
    }

    @Test
    public void t4() {
        System.out.println(columnistMapper.findColumnistAll());
    }

    @Test
    public void t5() {
        System.out.println(blogMapper.findBlogAll());
    }
}
