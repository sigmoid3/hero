package old.str;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class SimplePath {
	public static void main(String[] args) {
		String path = "//a/b/c/../d/../d/";
		SimplePath sol = new SimplePath();
		System.out.println(sol.simplifyPath(path));
	}
	public String simplifyPath(String path) {
		// /.current dict, //delete repeat, /..return /, /a in, ../out
		String[] pathArr = path.split("/");
		Stack<String> stack = new Stack<String>();
		for (String str : pathArr) {
			if (!stack.isEmpty() && str.equals("..")) {
				stack.pop();
				//"."change the str like "/./",""change the str like "//",".."change the str like "/../"
			} else if (!str.equals(".") && !str.equals("") && !str.equals("..")) {
				stack.push(str);
			}
		}
		//stack in Java has implemented the interface of List
		List<String> list = new ArrayList(stack);
		return "/" + String.join("/", list);
	}
}