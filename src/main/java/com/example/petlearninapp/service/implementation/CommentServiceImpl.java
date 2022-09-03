package com.example.petlearninapp.service.implementation;

import com.example.petlearninapp.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public void createComment(Long personId, String description) {

    }

    @Override
    public void deleteComment(Long personId) {

    }

    @Override
    public void modifyComment(Long personid, Long commentId, String description) {

    }
}
