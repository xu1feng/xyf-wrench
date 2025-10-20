package edu.xyf.wrench.task.job.provider;

import edu.xyf.wrench.task.job.model.TaskScheduleVO;

import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description: 任务数据提供者接口，用户需要实现此接口来提供任务调度数据
 * @Date: 2025/10/20 14:50
 */

public interface ITaskDataProvider {

    /**
     * 查询所有有效的任务调度配置
     * @return 任务调度配置列表
     */
    List<TaskScheduleVO> queryAllValidTaskSchedule();

    /**
     * 查询所有无效的任务ID
     * @return 无效任务ID列表
     */
    List<Long> queryAllInvalidTaskScheduleIds();

}
