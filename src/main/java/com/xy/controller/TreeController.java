package com.xy.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xy.util.TreeNode;

@Controller
@RequestMapping("/treeController")
@SessionAttributes("user")
public class TreeController {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value = "/getMenuTree")
	@ResponseBody
	public List<TreeNode> getMenuTree(String node) {
		String countSql = "select count(*) from organinfo where org_parent = f.org_id and  org_id <> org_parent";
        String sql =  "select org_id, org_name,org_parent, ("+countSql+") as count from organinfo f where org_parent = '"+node+"' and  org_id <> org_parent ";
        List<TreeNode> ret = jdbcTemplate.query(sql, new RowMapper(){
			public Object mapRow(ResultSet rs, int index) throws SQLException {
				TreeNode tn = new TreeNode();
				tn.setId(rs.getString("org_id"));
				tn.setText(rs.getString("org_name"));
				tn.setParentId(rs.getString("org_parent"));
				
				tn.setLeaf(rs.getInt("count") == 0);
				return tn;
			}
		});
		return ret;
	}
}
