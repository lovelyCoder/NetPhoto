package com.bishe.photo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.photo.domain.Message;
import com.bishe.photo.entity.Vote;
import com.bishe.photo.service.VoteService;

@Controller
@RequestMapping("/vote")
public class VoteController {
	
	@Autowired
	private VoteService voteService;
	@ResponseBody
	@RequestMapping("/vote.do")
	public Message addVote(Vote vote){
		try {
			voteService.addVote(vote);
		} catch (Exception e) {
			e.printStackTrace();
			return new Message("0","投票失败");
		}
		return this.getAvgVote(vote.getPhotoId());
	}
	@ResponseBody
	@RequestMapping("/getAvg.do")
	public Message getAvgVote(Integer photoId){
		return new Message("1",voteService.getAvgVote(photoId));
	}
	
}
