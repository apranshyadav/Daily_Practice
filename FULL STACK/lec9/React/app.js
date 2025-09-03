// let rootEl = document.getElementById("root");

// // let h1 = React.createElement("h1", null, "Hello RaoSahab");
// let h1 = React.createElement("h1", {id:"ap", className:'yadav'}, "Hello RaoSahab");

// let root = ReactDOM.createRoot(rootEl);
// root.render(h1);

let rootEl = document.getElementById("root");

let h1 = <div>
            <div>
                <h1>Hello RaoSahab JI</h1>
            </div>
            <div>
                <h2>Hello RaoSahab JIII</h2>
            </div>
        </div>

let root = ReactDOM.createRoot(rootEl);
root.render(h1);