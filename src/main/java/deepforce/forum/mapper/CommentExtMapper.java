package deepforce.forum.mapper;

import deepforce.forum.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}
