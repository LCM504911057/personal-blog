//package test;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.personal.blog.App;
//import com.personal.blog.dao.*;
//import com.personal.blog.entity.Blog;
//import com.personal.blog.entity.Columnist;
//import com.personal.blog.entity.User;
//import com.personal.blog.service.BlogService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//
////@RunWith(SpringRunner.class)
//@SpringBootTest(classes = App.class)
//public class Test01 {
//
//    @Autowired
//    UserMapper userMapper;
//
//    @Autowired
//    TagMapper tagMapper;
//
//    @Autowired
//    CommentMapper commentMapper;
//
//    @Autowired
//    ColumnistMapper columnistMapper;
//
//    @Autowired
//    BlogMapper blogMapper;
//
//    @Autowired
//    BlogService blogService;
//
//    @Test
//    public void testPage() {
//        PageHelper.startPage(1, 8);
//        Map<String, Object> map = new HashMap<>();
//        map.put("title", "测试");
//        PageInfo<Blog> pageInfo = blogService.getBlogByCondition(map);
////        PageInfo<Blog> pageInfo = blogService.getBlogPaging();
////        System.out.println(pageInfo.getList().size());
//
//        for (Blog blog : pageInfo.getList()) {
//            System.out.println(blog);
//        }
////        System.out.println(Arrays.toString(pageInfo.getList().toArray()));
//    }
//
//    @Test
//    public void t1() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "root");
//        User user = userMapper.findUserByCondition(map);
//        System.out.println(user);
////        System.out.println(userMapper);
////        System.out.println(userMapper.findUserAll());
//
//
//    }
//
//    @Test
//    public void t2() {
////        tagMapper.findTagAll();
//
////        Tag tag = new Tag();
////        tag.setId(1);
////        tag.setBlogCount(2);
////        tag.setCreateTime(new Date());
////        tag.setName("spring");
//
////        tagMapper.insertTag(tag);
//
////        System.out.println(tagMapper.findTagAll());
////
////        tagMapper.updateTag(tag);
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "spring");
//        System.out.println(tagMapper.findTagByCondition(map));
//    }
//
//    @Test
//    public void t3() {
//        System.out.println(commentMapper.findCommentAll());
//    }
//
//    @Test
//    public void testColumnist() {
//        for (int i = 0; i < 100 ; i++) {
//            Columnist c = new Columnist();
//            c.setBlogCount(1);
//            c.setCreateTime(new Date());
//            c.setIntro("java"+i);
//            c.setName("springboot" + i);
//            columnistMapper.insertColumnist(c);
//        }
//    }
//
//    @Test
//    public void testInsertBlog() {
//        for (int i = 0; i < 100 ; i++) {
//            Blog blog = new Blog();
//            blog.setId(100 + i);
//            blog.setTitle("你好" + i);
//            blog.setContent("内容" + i);
//            blog.setSummary("中文" + i);
//            blog.setCreateTime(new Date());
//            blog.setUpdateTime(new Date());
//            blog.setColumnId(1);
//            blog.setTags("1");
//            blog.setComments("c");
//            blog.setAdmireState(1);
//            blog.setCommentState(1);
//            blog.setRecommendState(1);
//            blog.setReprintState(1);
//            blog.setBlogImg("aaa");
//            blog.setBlogState(0);
//            blog.setViews(100);
//
//            blogMapper.insertBlog(blog);
//        }
//    }
//
//    @Test
//    public void t4() {
//        System.out.println(columnistMapper.findColumnistAll());
//    }
//
//    @Test
//    public void t5() {
//        System.out.println(blogMapper.findBlogAll());
//    }
//}
