package edu.xyf.wrench.task.job.service;

import edu.xyf.wrench.task.job.model.TaskScheduleVO;

/**
 * @Author: Xuyifeng
 * @Description: 任务调度服务接口
 * @Date: 2025/10/20 14:44
 */

public interface ITaskJobService {

    /**
     * 添加单个任务
     * @param task 任务调度配置
     * @return 是否添加成功
     */
    boolean addTask(TaskScheduleVO task);

    /**
     * 移除单个任务
     * @param taskId 任务ID
     * @return 是否移除成功
     */
    boolean removeTask(Long taskId);

    /**
     * 刷新任务调度配置
     */
    void refreshTasks();

    /**
     * 清理无效任务
     */
    void cleanInvalidTasks();

    /**
     * 停止所有任务
     */
    void stopAllTasks();

    /**
     * 获取当前活跃任务数量
     * @return 活跃任务数量
     */
    int getActiveTaskCount();

    /**
     * 初始化任务调度配置
     * 在服务启动时加载所有有效的任务调度配置
     */
    void initializeTasks();

}