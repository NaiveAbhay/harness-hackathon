var fs=require('fs');
var data=fs.readFileSync('merged/spec-first.json', 'utf8');
var words=JSON.parse(data);
func()
function func(){
  var temp =[
    {
      "name": "Roles",
      "tags": [
        "Account Roles",
        "Organization Roles",
        "Project Roles"
      ]
    },
    {
    "name" : "Organization",
    "tags" : [ "Organization" ]
  }, {
    "name" : "Project",
    "tags" : [ "Org Project" ]
  }, {
    "name" : "Secret",
    "tags" : [ "Account Secret", "Org Secret", "Project Secret" ]
  },
  {
    "name" : "Resource Groups",
    "tags" : [ "Account Resource Groups", "Organization Resource Groups", "Project Resource Groups" ]
  }
  ];
  words['x-tagGroups'] = temp;
  const x = JSON.stringify(words, null, 4);

  fs.writeFile('merged/spec-first.json', x, (err) => {
    if (err) {
        throw err;
    }
    console.log("JSON data is saved.");
  });
}
