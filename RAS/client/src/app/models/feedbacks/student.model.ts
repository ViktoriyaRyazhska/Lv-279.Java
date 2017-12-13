import {Mark} from "./mark.model";

export class StudentFeedback {
  id: number;
  user: User;
  academyId: number;
  data: Data;
  studentStatus: StudentStatus;
  approvedBy: ApprovedBy;
  teacherFeedback: Feedback;
  expertFeedback: Feedback;
  removed: boolean;
}

export class User {
  id: number;
  userName: string;
  email: string;
  firstName: string;
  lastName: string;
  phone: string;
  salt: string;
  password: string;
  englishLevel: string;
}

export class Data {
  engGram: number;
  englishLevel: EnglishLevel
  intermBase: number;
  intermLang: number;
  entryScore: number;
  testOne: number;
  testTwo: number;
  testThree: number;
  testFour: number;
  testFive: number;
  testSix: number;
  testSeven: number;
  testEight: number;
  testNine: number;
  testTen: number;
  finalBase: number;
  finalLang: number;
  incomingTest: number;
  teacherScore: number;
  expertScore: number;
  interviewerScore: number;
  interviewerComment: string;
}

export class EnglishLevel {
  englishLevelId: number;
  name: string;
}

export class StudentStatus {
  id: number;
  name: string;
}
export class ApprovedBy {
  employeeId: number;
  fullName: string;
}
export class Feedback {
  id: number;
  learningAbility: Mark;
  overallTechnicalCompetence: Mark;
  passionalInitiative: Mark;
  teamWork: Mark;
  gettingThingsDone: Mark;
  activeCommunicator: Mark;
  summary: string;
}
