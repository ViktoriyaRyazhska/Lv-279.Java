import {Tests} from "../../models/tests";
export  class TestsMock{
  public tests: Tests = {
    groupId : 586,
    // testName: ['test1', 'test2', 'test3', 'test4', 'test5', 'test6' ,'test7', 'test8', 'test9', 'test10'],
    // max_point: [11, 12, 13, 14, 15, 16, 17, 18, 19, 10]
    testName: 'test1',
    testMaxScore: 11
  };

  constructor(){
  }
}
