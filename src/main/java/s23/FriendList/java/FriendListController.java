package s23.FriendList.java;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import FriendList.domain.Friend;

@Controller
public class FriendListController {
	List<Friend> friendsList = new ArrayList<>();

	@GetMapping("/index")
	public String showFriends(@RequestParam(required = false) String friend, Model model) {
		if (friend != null && !friend.isEmpty()) {
	        friendsList.add(new Friend(friend));
	    }
	    
	    model.addAttribute("friendsList", friendsList);
	    model.addAttribute("friend", new Friend());  // if you still need this for some reason
	    
	    return "friendList";
	}

}
