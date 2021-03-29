package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: tommy wing
 * @description 对 Stream 的管道操作
 */
public class PipeOperation {
  public static void main(String[] args) {
    PipeOperation pipeOperation = new PipeOperation();
    // 筛选列表的非空元素
    List<String> stringList = Arrays.asList("a", "b", "", "c");
    pipeOperation.streamFilterForStringList(stringList);

    // 筛选重复元素
    List<String> stringList1 = Arrays.asList("a", "a", "b", "c");
    pipeOperation.streamDistinctForStringList(stringList1);

    // 截取列表的前N项
    List<String> stringList2 = Arrays.asList("a", "b", "c", "d");
    pipeOperation.streamLimitForStringList(stringList2);

    // 跳过列表的前N项
    List<String> stringList3 = Arrays.asList("e", "e", "a", "b", "c");
    pipeOperation.streamSkipForStringList(stringList3);

    // 将集合中的每个元素+1并且转换成字符串集合
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
    pipeOperation.streamMapForIntegerList(integerList);

    // 将 包裹多个小集合的大集合 合并成一个集合
    List<String> stringList4 = Arrays.asList("ok", "yes");
    List<String> stringList5 = Arrays.asList("ii", "jj");
    pipeOperation.streamFlatMapForStringList(stringList4, stringList5);

    // 输出是否匹配条件的结果
    List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4, 5);
    pipeOperation.streamAnyMatchForIntegerList(integerList1);

    //    输出所有元素都匹配条件结果
    pipeOperation.streamAllMatchForIntegerList(integerList);

    // 输出所有元素都不匹配的结果
    pipeOperation.streamNoneMatchForIntegerList(integerList);
  }

  public void printOutList(List list) {
    list.forEach(System.out::print);
    System.out.println();
  }

  /**
   * 1) 筛选 filter filter函数接收一个Lambda表达式作为参数，该表达式返回 boolean，在执行过程中 流将元素逐一输送给filter，并筛选出执行结果为 true
   * 的元素；
   *
   * @param list 字符串列表
   * @method filter()
   */
  public void streamFilterForStringList(List<String> list) {
    list = list.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
    printOutList(list);
  }

  /**
   * 2) 去重 distinct
   *
   * @param list 字符串列表
   * @method distinct()
   */
  public void streamDistinctForStringList(List<String> list) {
    list = list.stream().distinct().collect(Collectors.toList());
    printOutList(list);
  }

  /**
   * 3) 截取 limit 截取流的前N个元素
   *
   * @param list 字符串列表
   * @method limit()
   */
  public void streamLimitForStringList(List<String> list) {
    list = list.stream().limit(3).collect(Collectors.toList());
    printOutList(list);
  }

  /**
   * 4) 跳过 skip 跳过流的前n个元素
   *
   * @param list
   * @method skip()
   */
  public void streamSkipForStringList(List<String> list) {
    list = list.stream().skip(2).collect(Collectors.toList());
    printOutList(list);
  }

  /**
   * 5) 映射 map 对流中的每个元素执行一个函数，使得元素转换成另一种类型输出。流会将每一个元素输送给map函数 并执行map中的Lambda表达式，最后将执行结果存入一个新的流中。 如：将
   * list 中每一个 Integer类型元素自增后转化为 String类型
   *
   * @method map()
   * @param list
   */
  public void streamMapForIntegerList(List<Integer> list) {
    List<String> stringList =
        list.stream().map(x -> String.valueOf(++x)).collect(Collectors.toList());

    printOutList(stringList);
  }

  /**
   * 6) 合并多个流 flatMap 将两个列表合并成一个
   *
   * @method flatMap()
   * @param list1
   * @param list2
   * @return
   */
  public void streamFlatMapForStringList(List<String> list1, List<String> list2) {
    List<List<String>> list = Arrays.asList(list1, list2);
    List<String> stringList = list.stream().flatMap(List::stream).collect(Collectors.toList());
    printOutList(stringList);
  }

  /**
   * 7）匹配元素 ①是否匹配任一元素：anyMatch
   *
   * <p>anyMatch用于判断流中是否存在至少一个元素满足指定的条件，这个判断条件通过Lambda表达式传递给anyMatch，执行结果为boolean类型。
   *
   * @method anyMatch()
   * @param list
   */
  public void streamAnyMatchForIntegerList(List<Integer> list) {
    boolean flag = list.stream().anyMatch(x -> x > 10);
    System.out.println(flag);
  }

  /**
   * 返回元素都满足lambda表达式中条件的结果
   *
   * @method allMatch()
   * @param list
   */
  public void streamAllMatchForIntegerList(List<Integer> list) {
    boolean flag = list.stream().allMatch(x -> x > 10);
    System.out.println(flag);
  }

  /**
   * 输出所有不满足元素条件的结果
   *
   * @method noneMatch()
   * @param list
   */
  public void streamNoneMatchForIntegerList(List<Integer> list) {
    boolean flag = list.stream().noneMatch(x -> x > 10);
    System.out.println(flag);
  }
}
