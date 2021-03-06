package com.reddit.controller;

import static org.springframework.http.ResponseEntity.status;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reddit.dto.ApiResponse;
import com.reddit.dto.VoteDto;
import com.reddit.service.VoteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/votes")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class VoteController {

	private final VoteService voteService;
	
	@PostMapping
	public ResponseEntity<ApiResponse> vote(@RequestBody VoteDto voteDto){	
		return status(HttpStatus.OK).body(new ApiResponse(true, "Vote Done", voteService.vote(voteDto))) ;
	}
	
}