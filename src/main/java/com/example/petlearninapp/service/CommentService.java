package com.example.petlearninapp.service;

public interface CommentService {


    void createComment(Long personId, String description);

    void deleteComment(Long personId);

    void modifyComment(Long commentId, String description);
}
