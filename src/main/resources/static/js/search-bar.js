const articlesList = document.getElementById('articlesList');
const searchBar = document.getElementById('searchInput');
const allArticles = [];


fetch("http://localhost:8000/articles/api")
    .then(response => response.json())
    .then(data => {
        for (let d of data) {
            allArticles.push(d);
        }
    });

searchBar.addEventListener('keyup', (e) => {
    const searchingCharacters = searchBar.value.toLowerCase();
    let filteredArticles = allArticles.filter(article => {
        return article.title.toLowerCase().includes(searchingCharacters)
            || article.description.toLowerCase().includes(searchingCharacters);
    });

    const displayArticles = (articles) => {
        articlesList.innerHTML = articles
            .map((article) => {
                return `
            <div class="col-md-6">
                <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                        <p class="card-text border-bottom">${article.title}</p>
                        <p class="mb-1 text-muted">${article.createdOn}</p>
                        <p class="card-text mb-auto">${article.description}</p>
                        <a href="/static">Continue reading.....</a>
                    </div>
                </div>
            </div>`
            })
            .join('');

    }

    displayArticles(filteredArticles);
});



