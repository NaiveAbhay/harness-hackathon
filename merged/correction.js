var fs=require('fs');
var data=fs.readFileSync('merged/spec-first.json', 'utf8');
var data2 = fs.readFileSync('merged/x-tags.json', 'utf8');
var words=JSON.parse(data);
var xTags=JSON.parse(data2);
func()
function func(){
  words['x-tagGroups'] = xTags;
  const x = JSON.stringify(words, null, 4);

  fs.writeFile('merged/spec-first.json', x, (err) => {
    if (err) {
        throw err;
    }
    console.log("JSON data is saved.");
  });
}
