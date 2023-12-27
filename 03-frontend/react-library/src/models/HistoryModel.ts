class HistoryModel {
    id: number;
    email: string;
    checkoutDate: string;
    returnedDate: string;
    title: string;
    author: string;
    description: string;
    img: string;

    constructor(id: number, userEmail: string, checkoutDate: string, returnedDate: string,
        title: string, author: string, description: string, img: string) {
            this.id = id;
            this.email = userEmail;
            this.checkoutDate = checkoutDate;
            this.returnedDate = returnedDate;
            this.title = title;
            this.author = author;
            this.description = description;
            this.img = img;
    }
}

export default HistoryModel;