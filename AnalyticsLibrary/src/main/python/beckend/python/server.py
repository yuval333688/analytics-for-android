from flask import Flask
from flask_cors import CORS
# Use a relative import because utilities.py is in the same directory



app = Flask(__name__)
CORS(app)

# --- Database Connection Handling ---



# --- API Routes ---

@app.route("/")
def hello_world():
    """A simple route to confirm the server is running."""
    return "Hello, World!"

@app.route("/getNames")
def getNames():
    print("getNames called\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
    return "James Mary John Patricia Robert Jennifer Michael Linda William Elizabeth"

if __name__ == '__main__':

    app.run(host="0.0.0.0", port=5000, debug=True)
