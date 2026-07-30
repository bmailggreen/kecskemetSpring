function loadModifyBookHtml(id, author, title, releaseYear) {
	console.log('id: ' + id)
	console.log('author: ' + author)
	console.log('title: ' + title)
	console.log('releaseYear: ' + releaseYear)

	sessionStorage.setItem("bookId", id);
	sessionStorage.setItem("bookAuthor", author);
	sessionStorage.setItem("bookTitle", title);
	sessionStorage.setItem("bookReleaseYear", releaseYear);

	window.location.href = 'modifyBook.html';
//	document.getElementById("bookId").value = id;
//	document.getElementById("bookAuthor").value = author;
//	document.getElementById("bookTitle").value = title;
//	document.getElementById("bookReleaseYear").value = releaseYear;
}

function sendDeleteRequest(id) {
			const url = `http://localhost:8080/deleteBook?id=${id}`;

			// 3. Elküldjük a DELETE kérést (üres body-val, mert minden az URL-ben van)
			fetch(url, {
				method: 'DELETE'
			})
			.then(response => {
				if (response.ok) {
					alert('A könyv sikeresen törölve!');
					window.location.href = 'index.html';
				} else {
					alert('Szerverhiba történt a mentés során.');
				}
			})
			.catch(error => {
				console.error('Hiba a hálózati kérésben:', error);
			});
}


async function loadBooks() {

	console.log(window.location.origin);

    const response = await fetch("http://localhost:8080/getBooks");
    const books = await response.json();

	console.log(books)

    const container = document.getElementById("books");

	let htmlText = `
    <table>
        <tr>
            <th>Id</th>
            <th>Szerző</th>
            <th>Cím</th>
            <th>Kiadás Éve:</th>
            <th></th>
            <th></th>
        </tr>
	`

    books.forEach(book => {

        htmlText += `
        <tr>
            <td>${book.id}</td>
            <td>${book.author}</td>
            <td>${book.title}</td>
            <td>${book.releaseYear}</td>
            <td>
			<button onclick="loadModifyBookHtml(${book.id}, '${book.author}',
												'${book.title}', ${book.releaseYear})">
												Módosítás</button>
            </td>
            <td>
			<button onclick="sendDeleteRequest(${book.id})">
												Törlés</button>						
            </td>
        </tr>		
	`});
	
	htmlText += `
    </table>
	`;
	
	console.log(htmlText)	
	container.innerHTML = htmlText;
		
}

loadBooks();