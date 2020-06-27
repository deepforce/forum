package deepforce.forum.mapper;

import deepforce.forum.model.Question;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
}
