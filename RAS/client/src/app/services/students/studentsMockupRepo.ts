import {Student} from "../../models/student";
export  class StudentsMockupRepo{
  public students: Student[] = [
    {
      id: 1,
  firstName: "Andrii",
  lastName: "Barna",
  englishLevel: "Intermediate",
  entryScore: 545,
  intermLang: 453,
  intermBase: 458,
  englishGrammar: 151,
  incomingTest: 15,
  test1: 45,
  test2: 78,
  test3: 78,
  test4: 78,
  test5: 15,
  test6: 45,
  test7: 12,
  test8: 454,
  test9: 45,
  test10: 12,
  finalBase: 46,
  finalLang: 456,
  currentScore: 234,
  trainingScore: 456,
  teacheScore: 77,
  expertScore: 456,
  interviewerScore: 343,
  studentStatus: 1,
  personStatus: 1,
  approvedBy: "Mykola Marchuk",

  //additional candidate information
  age: 21,
  education: "NULP",
  strongSkills: "no weak ones",
  email: "andrybarna95@gmail.com",
  messenger: "andrii_barna",
  phone: "+380932266520",
  placeOfOrigin: "Bilobozhnytsya",
    },
  ];

  constructor(){
  }
}
