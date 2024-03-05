document.addEventListener("DOMContentLoaded", function () {
    let originalData;

    alert("si pasooo");
    loadDataAndRenderTable();

    document.getElementById("filterButton").addEventListener("click", filterDataAndRenderTable);
    document.getElementById("resetButton").addEventListener("click", resetFiltersAndRenderTable);

    function loadDataAndRenderTable() {
        axios.get("/dragonball")
            .then(function (response) {
                originalData = response.data;
                renderTable(originalData);
                fillRaceOptions(originalData);
            })
            .catch(function (error) {
                console.error("Error loading Dragon Ball data:", error);
            });
    }

    function renderTable(characters) {
        const table = document.getElementById("characterTable");
        const tbody = table.querySelector("tbody");

        tbody.innerHTML = "";

        characters.forEach(function (character) {
            const row = document.createElement("tr");
            row.innerHTML = `<td>${character.id}</td><td>${character.name}</td><td>${character.ki}</td><td>${character.race}</td><td>${character.description}</td><td><img src="${character.image}" alt="${character.name}" style="max-width: 100px; max-height: 100px;"></td><td>${character.maxKi}</td><td>${character.gender}</td><td>${character.affiliation}</td>`;
            tbody.appendChild(row);
        });
    }

    function fillRaceOptions(characters) {
        const raceFilter = document.getElementById("raceFilter");
        const uniqueRaces = [...new Set(characters.map(character => character.race))];

        uniqueRaces.forEach(function (race) {
            const option = document.createElement("option");
            option.value = race;
            option.text = race;
            raceFilter.add(option);
        });
    }

    function filterDataAndRenderTable() {
        const kiRange = document.getElementById("kiRange").value;
        const selectedRace = document.getElementById("raceFilter").value;

        let filteredCharacters = [...originalData];

        if (kiRange) {
            const [minKi, maxKi] = kiRange.split("-").map(Number);
            filteredCharacters = filteredCharacters.filter(character => {
                const kiValue = Number(character.ki.replace(/\./g, '')) || 0;
                return kiValue >= minKi && kiValue <= maxKi;
            });
        }

        if (selectedRace) {
            filteredCharacters = filteredCharacters.filter(character => character.race === selectedRace);
        }

        renderTable(filteredCharacters);
    }

    function resetFiltersAndRenderTable() {
        document.getElementById("kiRange").value = "";
        document.getElementById("raceFilter").value = "";

        loadDataAndRenderTable();
    }
});
