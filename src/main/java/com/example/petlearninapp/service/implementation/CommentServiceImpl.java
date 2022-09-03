package com.example.petlearninapp.service.implementation;

import com.example.petlearninapp.Model.Comment;
import com.example.petlearninapp.Model.Person;
import com.example.petlearninapp.repository.CommentRepository;
import com.example.petlearninapp.repository.PersonRepository;
import com.example.petlearninapp.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private final PersonRepository personRepository;

    private final CommentRepository commentRepository;

    public CommentServiceImpl(PersonRepository personRepository, CommentRepository commentRepository) {
        this.personRepository = personRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void createComment(Long personId, String description) {
        Person p = this.personRepository.findById(personId).get();

        this.commentRepository.save(new Comment(p, description));
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment c = this.commentRepository.findById(commentId).get();

        this.commentRepository.delete(c);
    }

    @Override
    public void modifyComment(Long commentId, String description) {
        Comment c = this.commentRepository.findById(commentId).get();
        c.setDescription(description);
        this.commentRepository.save(c);
    }
}
