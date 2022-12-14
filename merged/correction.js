const yaml = require('js-yaml');
var fs=require('fs');
var words = yaml.safeLoad(fs.readFileSync('merged/spec-first.yaml', 'utf8'));
var xTags = yaml.safeLoad(fs.readFileSync('merged/x-tags.yaml', 'utf8'));
func()
function func(){
  words['x-tagGroups'] = xTags;
  const yamlStr = yaml.safeDump(words)

  fs.writeFile('merged/spec-first.yaml', yamlStr, (err) => {
    if (err) {
        throw err;
    }
    console.log("YAML data is saved.");
  });
}
