package org.example.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * ユーザをまとめて作成するタスクを実行するコンポーネントの実装です。
 */
@Component
public class UserBatchCreatorImpl implements UserBatchCreator {
    private static final Logger logger = LoggerFactory.getLogger(UserBatchCreatorImpl.class);

    private final UserRepository userRepository;

    private final BatchCreateUsersTaskRepository batchCreateUsersTaskRepository;

    /**
     * @param userRepository ユーザリポジトリ
     * @param batchCreateUsersTaskRepository ユーザ作成タスクリポジトリ
     */
    public UserBatchCreatorImpl(UserRepository userRepository, BatchCreateUsersTaskRepository batchCreateUsersTaskRepository) {
        this.userRepository = userRepository;
        this.batchCreateUsersTaskRepository = batchCreateUsersTaskRepository;
    }

    @Async
    @Transactional
    @Override
    public void createUsers(BatchCreateUsersTask task, int count) {
        for (int i = 0; i < count; i++) {
            logger.trace("i: {}", i);
            userRepository.save(new User(null, "user" + i));
        }
        batchCreateUsersTaskRepository.save(new BatchCreateUsersTask(task.getId(), "completed"));
    }
}
