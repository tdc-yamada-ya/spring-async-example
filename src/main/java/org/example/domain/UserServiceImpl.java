package org.example.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserBatchCreatorImpl.class);

    private final UserBatchCreator userBatchCreator;

    private final BatchCreateUsersTaskRepository batchCreateUsersTaskRepository;

    @Autowired
    public UserServiceImpl(UserBatchCreator userBatchCreator, BatchCreateUsersTaskRepository batchCreateUsersTaskRepository) {
        this.userBatchCreator = userBatchCreator;
        this.batchCreateUsersTaskRepository = batchCreateUsersTaskRepository;
    }

    @Override
    @Transactional
    public BatchCreateUsersTask batchCreateUsers(int count) {
        BatchCreateUsersTask savedTask = batchCreateUsersTaskRepository.save(new BatchCreateUsersTask(null, "started"));
        userBatchCreator.createUsers(savedTask, count);
        return savedTask;
    }

    @Override
    public BatchCreateUsersTask getBatchCreateUserTask(String id) {
        logger.trace("id: {}", id);
        return batchCreateUsersTaskRepository.get(id);
    }
}
