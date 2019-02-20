export class Reservation {
    // private id: number;
    // private beds: number;
    // private comments: string;
    // private client: any[];
    // private fromDate: string;
    // private toDate: string;
    id: number;
    beds: number;
    comments: string;
    client: any[];
    fromDate: string;
    toDate: string;

    constructor(obj?: any) {
        this.id = (obj && obj.id) || null;
        this.beds = (obj && obj.id) || null;
        this.comments = (obj && obj.comments) || null;
        this.client = (obj && obj.client) || null;
        this.fromDate = (obj && obj.fromDate) || null;
        this.toDate = (obj && obj.toDate) || null;
  }

  // getId(): number {
  //   return this.id;
  // }
  // getBeds(): number {
  //   return this.beds;
  // }

  // isFinished(): boolean {
  //   return this.finished;
  // }
  // toggleStatus(): void {
  //   this.finished = !this.finished;
  // }
}
